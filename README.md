<h2>Instalacion</h2>

Bajar IntelliJ IDEA/ ECLIPSE
http://www.scala-lang.org/download/

<h3>Pasos para IntelliJ IDEA</h3>

1. Clonar Proyecto
`git clone https://github.com/pdbenitez/g4-tadp-1c2014-como-viajo.git`

2. Bajar Scala y descomprimirlo en la carpeta deseada.
http://www.scala-lang.org/download/


3. Abrir IntelliJ IDEA
 
 En Linux alcanza con correr el idea.sh  
 En el menu elejir importar proyecto y seleccionarlo.  
 Dar OK a todas las cosas q se pidan menos a agregar archivos al repositorio de GIT.  
 Luego click derecho en el proyecto y elejir "Add Framework Support.."  
 Elejir Scala y seleccionar donde se lo extrajo.  

4. Para utilizar ScalaTests
 
 Click derecho en el proyecto e ir a "Open Module Settings". Ir a Global Libraries.  
 Seleccionar el + y bajar de Maven.  
 Para ScalaTest: org.scalatest:scalatest_2.11:2.1.7  
 Luego click derecho en cada una individualmente y poner "Add to modules.." (Si es que no te lo pidio antes).  
 Dar a ok y no copiar realmente sino que la libreria sea enlazada.  
 
 Para usar ScalaTest aca una guia: http://www.scalatest.org/user_guide

> Nota: no logre agregar el framework support para Maven porque rompia todo el proyecto, God Knows Why.  
