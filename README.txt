

This is the archetype to create GWT PWAs.

- Assuming you have installed maven, compile and install it just running:
$ mvn clean install

- To use the archetype run:

        $ mvn archetype:generate -DarchetypeArtifactId=gwt-pwa-archetype \
                       -DarchetypeVersion=1.0-SNAPSHOT \
                       -DarchetypeGroupId=com.vaadin.polymer \
                       -DgroupId=com.example \
                       -DartifactId=pwa-app \
                       -DprojectName=MyPwaApp \
                       -Dpackage=com.example.pwa \

- Then change to the project folder and compile it.
  - To build the PWA version of the application, run:

        $ mvn clean package -Ppwa 

  - To build the classic GWT version of the application, run:

        $ mvn clean package

- To run the application in development mode run:

        $ mvn gwt:devmode
