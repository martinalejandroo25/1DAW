import os

def crear_estructura_ciberseguridad(ruta_base="ciberseguridad"):
    """
    Crea la estructura de directorios y archivos para la página web de ciberseguridad.

    Args:
        ruta_base (str): La ruta donde se creará la estructura.
    """

    # Crear la carpeta raíz si no existe
    if not os.path.exists(ruta_base):
        os.makedirs(ruta_base)
        print(f"Carpeta raíz creada: {ruta_base}")
    else:
        print(f"La carpeta raíz ya existe: {ruta_base}")

    # Crear subcarpetas principales
    subcarpetas_principales = [
        "css",
        "js",
        "img",
        "conceptos-fundamentales",
        "amenazas-vulnerabilidades",
        "proteccion-buenas-practicas",
        "herramientas",
        "noticias",
        "recursos",
        "acerca-de",
        "contacto"
    ]
    for carpeta in subcarpetas_principales:
        ruta_completa = os.path.join(ruta_base, carpeta)
        if not os.path.exists(ruta_completa):
            os.makedirs(ruta_completa)
            print(f"Carpeta creada: {ruta_completa}")
        else:
            print(f"La carpeta ya existe: {ruta_completa}")

    # Crear archivos base en la raíz
    archivos_raiz = ["index.html"]
    for archivo in archivos_raiz:
        ruta_completa = os.path.join(ruta_base, archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write("<!DOCTYPE html>\n<html lang=\"es\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>El Mundo de la Ciberseguridad</title>\n    <link rel=\"stylesheet\" href=\"css/style.css\">\n</head>\n<body>\n    <header>\n        <nav>\n            <ul>\n                <li><a href=\"index.html\">Inicio</a></li>\n                <li><a href=\"conceptos-fundamentales/\">Conceptos Fundamentales</a></li>\n                <li><a href=\"amenazas-vulnerabilidades/\">Amenazas y Vulnerabilidades</a></li>\n                <li><a href=\"proteccion-buenas-practicas/\">Protección y Buenas Prácticas</a></li>\n                <li><a href=\"herramientas/\">Herramientas</a></li>\n                <li><a href=\"noticias/\">Noticias</a></li>\n                <li><a href=\"recursos/\">Recursos</a></li>\n                <li><a href=\"acerca-de/\">Acerca de</a></li>\n                <li><a href=\"contacto/\">Contacto</a></li>\n            </ul>\n        </nav>\n    </header>\n    <main>\n        <h1>Bienvenido al Mundo de la Ciberseguridad</h1>\n        <p>Este es un sitio web sobre el fascinante mundo de la ciberseguridad.</p>\n    </main>\n    <footer>\n        <p>&copy; 2025 El Mundo de la Ciberseguridad</p>\n    </footer>\n    <script src=\"js/script.js\"></script>\n</body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    # Crear archivos CSS y JS vacíos
    css_file = os.path.join(ruta_base, "css", "style.css")
    if not os.path.exists(css_file):
        with open(css_file, "w") as f:
            pass
        print(f"Archivo creado: {css_file}")
    else:
        print(f"El archivo ya existe: {css_file}")

    js_file = os.path.join(ruta_base, "js", "script.js")
    if not os.path.exists(js_file):
        with open(js_file, "w") as f:
            pass
        print(f"Archivo creado: {js_file}")
    else:
        print(f"El archivo ya existe: {js_file}")

    # Crear archivos dentro de "conceptos-fundamentales"
    conceptos_archivos = ["index.html", "que-es-ciberseguridad.html", "triada-cia.html", "tipos-de-hackers.html"]
    for archivo in conceptos_archivos:
        ruta_completa = os.path.join(ruta_base, "conceptos-fundamentales", archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    # Crear archivos y subcarpetas dentro de "amenazas-vulnerabilidades"
    amenazas_base = os.path.join(ruta_base, "amenazas-vulnerabilidades")
    amenazas_archivos = ["index.html", "malware.html", "ataques-de-red.html", "ingenieria-social.html", "seguridad-web.html", "seguridad-wifi.html"]
    for archivo in amenazas_archivos:
        ruta_completa = os.path.join(amenazas_base, archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    subcarpetas_amenazas = ["malware", "ataques-de-red", "ingenieria-social", "seguridad-web", "seguridad-wifi"]
    for subcarpeta in subcarpetas_amenazas:
        ruta_completa = os.path.join(amenazas_base, subcarpeta)
        if not os.path.exists(ruta_completa):
            os.makedirs(ruta_completa)
            print(f"Carpeta creada: {ruta_completa}")
        else:
            print(f"La carpeta ya existe: {ruta_completa}")
        # Crear archivos dentro de las subcarpetas de amenazas
        if subcarpeta == "malware":
            archivos_malware = ["virus.html", "ransomware.html", "spyware.html"]
            for archivo in archivos_malware:
                ruta_archivo = os.path.join(ruta_completa, archivo)
                if not os.path.exists(ruta_archivo):
                    with open(ruta_archivo, "w") as f:
                        f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
                    print(f"Archivo creado: {ruta_archivo}")
                else:
                    print(f"El archivo ya existe: {ruta_archivo}")
        elif subcarpeta == "ataques-de-red":
            archivos_red = ["dos-ddos.html", "man-in-the-middle.html"]
            for archivo in archivos_red:
                ruta_archivo = os.path.join(ruta_completa, archivo)
                if not os.path.exists(ruta_archivo):
                    with open(ruta_archivo, "w") as f:
                        f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
                    print(f"Archivo creado: {ruta_archivo}")
                else:
                    print(f"El archivo ya existe: {ruta_archivo}")
        elif subcarpeta == "ingenieria-social":
            archivos_social = ["phishing.html", "vishing.html", "smishing.html"]
            for archivo in archivos_social:
                ruta_archivo = os.path.join(ruta_completa, archivo)
                if not os.path.exists(ruta_archivo):
                    with open(ruta_archivo, "w") as f:
                        f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
                    print(f"Archivo creado: {ruta_archivo}")
                else:
                    print(f"El archivo ya existe: {ruta_archivo}")
        elif subcarpeta == "seguridad-web":
            archivos_web = ["sql-injection.html", "xss.html"]
            for archivo in archivos_web:
                ruta_archivo = os.path.join(ruta_completa, archivo)
                if not os.path.exists(ruta_archivo):
                    with open(ruta_archivo, "w") as f:
                        f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
                    print(f"Archivo creado: {ruta_archivo}")
                else:
                    print(f"El archivo ya existe: {ruta_archivo}")
        elif subcarpeta == "seguridad-wifi":
            archivos_wifi = ["wep.html", "wpa.html", "wpa2.html", "wpa3.html", "ataques-fuerza-bruta.html", "rogue-aps.html", "evil-twin.html"]
            for archivo in archivos_wifi:
                ruta_archivo = os.path.join(ruta_completa, archivo)
                if not os.path.exists(ruta_archivo):
                    with open(ruta_archivo, "w") as f:
                        f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
                    print(f"Archivo creado: {ruta_archivo}")
                else:
                    print(f"El archivo ya existe: {ruta_archivo}")

    # Crear archivos dentro de "proteccion-buenas-practicas"
    proteccion_base = os.path.join(ruta_base, "proteccion-buenas-practicas")
    proteccion_archivos = ["index.html", "contraseñas-seguras.html", "gestores-contraseñas.html", "autenticacion-multifactor.html", "actualizaciones-parches.html", "antivirus-antimalware.html", "firewalls.html", "vpns.html", "navegacion-segura.html", "copias-de-seguridad.html"]
    for archivo in proteccion_archivos:
        ruta_completa = os.path.join(proteccion_base, archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    # Crear archivos dentro de "herramientas"
    herramientas_base = os.path.join(ruta_base, "herramientas")
    herramientas_archivos = ["index.html", "nmap.html", "wireshark.html", "metasploit.html", "kali-linux.html"]
    for archivo in herramientas_archivos:
        ruta_completa = os.path.join(herramientas_base, archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    # Crear archivo index en "noticias"
    noticias_index = os.path.join(ruta_base, "noticias", "index.html")
    if not os.path.exists(noticias_index):
        with open(noticias_index, "w") as f:
            f.write("<!DOCTYPE html>\n<html>\n<head><title>Noticias de Ciberseguridad</title></head>\n<body><h1>Noticias de Ciberseguridad</h1><p>Aquí encontrarás las últimas noticias y artículos sobre ciberseguridad.</p></body>\n</html>")
        print(f"Archivo creado: {noticias_index}")
    else:
        print(f"El archivo ya existe: {noticias_index}")

    # Crear archivos dentro de "recursos"
    recursos_base = os.path.join(ruta_base, "recursos")
    recursos_archivos = ["index.html", "enlaces.html", "libros.html", "cursos.html"]
    for archivo in recursos_archivos:
        ruta_completa = os.path.join(recursos_base, archivo)
        if not os.path.exists(ruta_completa):
            with open(ruta_completa, "w") as f:
                f.write(f"<!DOCTYPE html>\n<html>\n<head><title>{archivo.replace('.html', '').replace('-', ' ').title()}</title></head>\n<body><h1>{archivo.replace('.html', '').replace('-', ' ').title()}</h1></body>\n</html>")
            print(f"Archivo creado: {ruta_completa}")
        else:
            print(f"El archivo ya existe: {ruta_completa}")

    # Crear archivo index en "acerca-de"
    acerca_index = os.path.join(ruta_base, "acerca-de", "index.html")
    if not os.path.exists(acerca_index):
        with open(acerca_index, "w") as f:
            f.write("<!DOCTYPE html>\n<html>\n<head><title>Acerca de</title></head>\n<body><h1>Acerca de este sitio web</h1><p>Información sobre el propósito de este sitio.</p></body>\n</html>")
        print(f"Archivo creado: {acerca_index}")
    else:
        print(f"El archivo ya existe: {acerca_index}")

    # Crear archivo index en "contacto"
    contacto_index = os.path.join(ruta_base, "contacto", "index.html")
    if not os.path.exists(contacto_index):
        with open(contacto_index, "w") as f:
            f.write("<!DOCTYPE html>\n<html>\n<head><title>Contacto</title></head>\n<body><h1>Contacto</h1><p>Formulario de contacto o información de contacto.</p></body>\n</html>")
        print(f"Archivo creado: {contacto_index}")
    else:
        print(f"El archivo ya existe: {contacto_index}")

if __name__ == "__main__":
    crear_estructura_ciberseguridad()
    print("\nEstructura de carpetas y archivos creada exitosamente en la carpeta 'ciberseguridad'.")