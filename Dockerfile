FROM jetty
MAINTAINER @sidlors at github
# Se agregan metadatos a la imagen
LABEL Descripcion="Ejemplo de ajax4jsf" Autor="Juan Manuel Hernandez" Version="v1.0.0"
# Se copia el war pre compilado y se deposita en el contenedor 
COPY target/ajax4jsf.war $JETTY_BASE/webapps
RUN java -jar "$JETTY_HOME/start.jar" --add-to-startd=jmx,stats