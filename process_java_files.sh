#!/bin/bash

# Clean up previous results and ensure result files exist
original_dir_for_java_command=$PWD # Save current PWD
touch "$original_dir_for_java_command/compilation_success.txt" \
      "$original_dir_for_java_command/compilation_failure.txt" \
      "$original_dir_for_java_command/runtime_success.txt" \
      "$original_dir_for_java_command/runtime_failure.txt"
rm -f "$original_dir_for_java_command/compilation_success.txt" \
      "$original_dir_for_java_command/compilation_failure.txt" \
      "$original_dir_for_java_command/runtime_success.txt" \
      "$original_dir_for_java_command/runtime_failure.txt"
touch "$original_dir_for_java_command/compilation_success.txt" \
      "$original_dir_for_java_command/compilation_failure.txt" \
      "$original_dir_for_java_command/runtime_success.txt" \
      "$original_dir_for_java_command/runtime_failure.txt"

# Read file list from stdin
files=$(cat)

for filepath in $files; do
  echo "Processing $filepath"

  dir=$(dirname "$filepath")
  filename=$(basename "$filepath")
  classname="${filename%.java}"
  
  effective_compile_root=""
  path_to_java_file_from_compile_root=""
  qualified_classname=""

  # Case 1: Standard Maven-like structure 'src/main/java' or 'src/test/java'
  if [[ "$filepath" == *"src/main/java/"* ]]; then
    effective_compile_root=$(echo "$filepath" | sed 's|\(.*\)/src/main/java/.*|\1/src/main/java|')
    path_to_java_file_from_compile_root=$(echo "$filepath" | sed "s|$effective_compile_root/||")
    package_prefix=$(dirname "$path_to_java_file_from_compile_root" | tr '/' '.')
    qualified_classname="${package_prefix}.$classname"
  elif [[ "$filepath" == *"src/test/java/"* ]]; then
    effective_compile_root=$(echo "$filepath" | sed 's|\(.*\)/src/test/java/.*|\1/src/test/java|')
    path_to_java_file_from_compile_root=$(echo "$filepath" | sed "s|$effective_compile_root/||")
    package_prefix=$(dirname "$path_to_java_file_from_compile_root" | tr '/' '.')
    qualified_classname="${package_prefix}.$classname"
  # Case 2: Structure with 'src/' as the root of packages (e.g. Programacion/Project/src/com/example/MyClass.java)
  # or files directly in 'src' (e.g. Programacion/Project/src/MyClass.java)
  elif [[ "$filepath" == *"src/"* ]]; then
    effective_compile_root=$(echo "$filepath" | sed 's|\(.*src\)/.*|\1|') # The directory ending in /src, e.g., Programacion/Project/src
    path_to_java_file_from_compile_root=$(echo "$filepath" | sed "s|$effective_compile_root/||") # e.g., com/example/MyClass.java or MyClass.java
    
    package_prefix_path=$(dirname "$path_to_java_file_from_compile_root")
    if [[ "$package_prefix_path" == "." ]]; then # No subdirectories under src, default package
      qualified_classname="$classname"
    else
      package_prefix=$(echo "$package_prefix_path" | tr '/' '.')
      qualified_classname="$package_prefix.$classname"
    fi
  # Case 3: Files under Programacion/TemaX/..., Programacion/EjerciciosIntroduccionPDF/..., etc.
  # These are treated as if "Programacion" is the main source root.
  elif [[ "$filepath" =~ ^Programacion/((Tema[^/]+|Ejercicios[^/]+|Interfaces[^/]+|ProgramacionFuncional[^/]+|Streams[^/]+)/.+) || "$filepath" =~ ^Programacion/([^/]+)$ && "$filename" != "funciones.java" ]]; then
    effective_compile_root="Programacion"
    path_to_java_file_from_compile_root=$(echo "$filepath" | sed "s|^Programacion/||") # e.g. Tema1/EjerciciosPDF/Ejercicio1.java
    
    package_prefix_path=$(dirname "$path_to_java_file_from_compile_root")
    if [[ "$package_prefix_path" == "." ]]; then # file is directly in Programacion/
        qualified_classname="$classname"
    else
        package_prefix=$(echo "$package_prefix_path" | tr '/' '.')
        qualified_classname="$package_prefix.$classname"
    fi
  # Case 4: Specific known complex projects like VersionDeChatGPT
  elif [[ "$filepath" == *"Programacion/Tema7/PruebaEscritaV2Repaso/VersionDeChatGPT/"* ]]; then
    effective_compile_root="Programacion/Tema7/PruebaEscritaV2Repaso/VersionDeChatGPT"
    path_to_java_file_from_compile_root=$(echo "$filepath" | sed "s|$effective_compile_root/||")
    package_prefix_path=$(dirname "$path_to_java_file_from_compile_root")
    if [[ "$package_prefix_path" == "." ]]; then
        qualified_classname="$classname"
    else
        package_prefix=$(echo "$package_prefix_path" | tr '/' '.')
        qualified_classname="$package_prefix.$classname"
    fi
  # Case 5: Files directly in a subdirectory of Programacion, where that subdirectory is the root
  # e.g. Programacion/Examen1Evaluacion/Ejercicio1.java -> classname Ejercicio1, compile from Programacion/Examen1Evaluacion
  elif [[ "$dir" =~ ^Programacion/[^/]+$ ]]; then
    effective_compile_root="$dir"
    path_to_java_file_from_compile_root="$filename" # Just the filename
    qualified_classname="$classname" # No package
  # Fallback: file's own directory is root, no package. (e.g. Programacion/funciones.java)
  else
    effective_compile_root="$dir"
    path_to_java_file_from_compile_root="$filename"
    qualified_classname="$classname"
  fi

  echo "Attempting to compile $filepath"
  echo "  Effective compile root (cd to): $effective_compile_root"
  echo "  Path to java file from compile root: $path_to_java_file_from_compile_root"
  echo "  Qualified classname for java: $qualified_classname"

  temp_out_dir=$(mktemp -d)

  compile_log_file="$original_dir_for_java_command/compile_error.log"
  run_log_file="$original_dir_for_java_command/run_error.log"
  java_stdout_log_file="$original_dir_for_java_command/java_run.log"
  
  rm -f "$compile_log_file" "$run_log_file" "$java_stdout_log_file" # Clear logs for current file

  (cd "$effective_compile_root" && javac -d "$temp_out_dir" -Xlint:none "$path_to_java_file_from_compile_root" 2>"$compile_log_file")
  compile_status=$?

  if [ $compile_status -eq 0 ]; then
    echo "$filepath" >> "$original_dir_for_java_command/compilation_success.txt"
    echo "Compilation successful for $filepath"

    if [[ "$classname" == *"Main"* || "$classname" == *"Test"* || "$classname" == *"Ejecutable"* || "$classname" == *"App"* || "$classname" == *"Ejercicio"* ]]; then
      echo "Attempting to run $qualified_classname using classpath $temp_out_dir"
      
      java -cp "$temp_out_dir" "$qualified_classname" >>"$java_stdout_log_file" 2>"$run_log_file"
      run_status=$?

      if [ $run_status -eq 0 ]; then
        # Check if actual errors were printed to stderr despite exit code 0
        if [ -s "$run_log_file" ] && ! (grep -q "Picked up _JAVA_OPTIONS" "$run_log_file" && [ $(wc -l < "$run_log_file") -eq 1 ]); then
            echo "$filepath - $(cat "$run_log_file")" >> "$original_dir_for_java_command/runtime_failure.txt"
            echo "Execution technically succeeded (exit 0) but produced stderr for $filepath"
        else
            echo "$filepath" >> "$original_dir_for_java_command/runtime_success.txt"
            echo "Execution successful for $filepath"
        fi
      else
        # Standard failure case
        if [ -s "$run_log_file" ]; then
            echo "$filepath - $(cat "$run_log_file")" >> "$original_dir_for_java_command/runtime_failure.txt"
        else
            echo "$filepath - Execution failed with no error message to stderr (Code: $run_status)" >> "$original_dir_for_java_command/runtime_failure.txt"
        fi
        echo "Execution failed for $filepath (Code: $run_status)"
      fi
    else
      echo "Skipping execution for $filepath (not a typical main class name)"
    fi
  else
    if [ -s "$compile_log_file" ]; then
        echo "$filepath - $(cat "$compile_log_file")" >> "$original_dir_for_java_command/compilation_failure.txt"
    else
        echo "$filepath - Compilation failed with no error message." >> "$original_dir_for_java_command/compilation_failure.txt"
    fi
    echo "Compilation failed for $filepath"
  fi
  
  rm -rf "$temp_out_dir" # Clean up temp directory
  # Logs are now managed per file at the start of the loop or kept if errors occurred
done

# Clean up global log files if they are empty at the end, to avoid confusion
[ ! -s "$compile_log_file" ] && rm -f "$compile_log_file"
[ ! -s "$run_log_file" ] && rm -f "$run_log_file"
[ ! -s "$java_stdout_log_file" ] && rm -f "$java_stdout_log_file"

echo "Processing complete."
