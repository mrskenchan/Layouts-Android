# 🇨🇱 Recetario Chileno App

Aplicación móvil para gestionar recetas tradicionales chilenas. Permite agregar, editar, eliminar y visualizar recetas de diversas zonas del país (norte, centro y sur), almacenando los datos localmente con SQLite.  

---

## 📑 Contenido
- [Características](#características)
- [Capturas](#capturas)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Instalación](#instalación)
- [Uso](#uso)
- [Tecnologías](#tecnologías)
- [Autores](#autores)
- [Licencia](#licencia)

---

## ✨ Características
- CRUD completo de recetas chilenas (crear, leer, actualizar, eliminar)
- Base de datos local SQLite para almacenamiento offline
- Interfaz intuitiva y moderna con Material Design
- Categorización por zona geográfica
- Integración con cámara y galería para añadir imágenes
- Validación de campos y manejo de errores
- Posibilidad de expansión futura con Firebase

---

## 🖼️ Capturas
Menu de la aplicacion:
<img width="200" height="806" alt="Captura de pantalla 2025-10-13 160315" src="https://github.com/user-attachments/assets/7e407dfe-6d31-43b1-aa4f-53f9afd0d941" />
Agregar una receta:
<img width="377" height="799" alt="Captura de pantalla 2025-10-13 160623" src="https://github.com/user-attachments/assets/a085288f-bf83-46cb-9e8e-3398954a3b14" />
Ver todas las recetas:
<img width="377" height="807" alt="Captura de pantalla 2025-10-13 160924" src="https://github.com/user-attachments/assets/9a2c1fcb-6548-416f-86e9-33dbd30973eb" />
---

## 🧩 Estructura del proyecto
```
📁 com.example.layout_android
┣ 📁 adapters
┃ ┗ 📄 RecetasAdapter.java
┣ 📁 Contratos
┃ ┣ 📄 AutorContract.java
┃ ┣ 📄 FoodContract.java
┃ ┣ 📄 IngredientContract.java
┃ ┣ 📄 RecipeIngredientContract.java
┃ ┗ 📄 RegionContract.java
┣ 📄 activity_main.java
┣ 📄 activity_resena.java
┣ 📄 DBHelper.java
┣ 📄 DetalleRecetaActivity.java
┣ 📄 EditarRecetaActivity.java
┣ 📄 ListaRecetasActivity.java
┗ 📄 Receta.java

📁 res
┣ 📁 drawable
┗ 📁 layout
┣ 📄 activity_detalle_receta.xml
┣ 📄 activity_editar_receta.xml
┣ 📄 activity_inicios.xml
┣ 📄 activity_lista_recetas.xml
┣ 📄 activity_main.xml
┣ 📄 activity_resena.xml
┗ 📄 item_receta.xml
```
---

## ⚙️ Instalación
1. Clona el repositorio:  https://github.com/mrskenchan/Layouts-Android.git
2. Ábrelo en Android Studio.  
3. Compila el proyecto y ejecútalo en un emulador o dispositivo Android físico.  

---

## 🚀 Uso
- Desde la pantalla principal puedes **ver todas las recetas almacenadas**.  
- Usa el botón **“Comparte tu receta”** para agregar una nueva receta.  
- **Desliza o selecciona opciones** para editar o eliminar una receta.  
- Se pueden **tomar fotos** con la cámara o adjuntar imágenes desde la galería.  

---

## 🧰 Tecnologías
- Java  
- SQLite  
- Android SDK  
- Material Design Components  
- Android Studio 2025.1.3  
- (Próximamente) Firebase Realtime Database  

---

## 🤝 Contribuir
1. Realiza un fork del proyecto.  
2. Crea una rama para tu mejora (`git checkout -b mejora/nueva-funcionalidad`).  
3. Realiza los cambios y documentación correspondiente.  
4. Envía un Pull Request.  

---

## 👨‍💻 Autor
Desarrollado por 
[Kenjiro Aguilera](https://github.com/mrskenchan).
[Cristobal Gómez](https://github.com/cristobalGomez189).
[Matías Ulloa](https://github.com/Hankk21).
Proyecto educativo y de difusión cultural sobre la gastronomía chilena.

---

## 🧾 Licencia
Distribuido bajo la licencia MIT. Consulta el archivo `LICENSE` para más información.  

---

