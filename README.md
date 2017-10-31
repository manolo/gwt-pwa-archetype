

### An archetype to create GWT PWAs.

#### Installing the archetype locally

1. Clone this project.

        $ git clone https://github.com/manolo/gwt-pwa-archetype.git
 
2. Assuming that you have installed maven, compile and install the archetype by running:

        $ mvn clean install

#### Using the archetype

- To create a new GWT PWA project run:

```
mvn archetype:generate -DarchetypeArtifactId=gwt-pwa-archetype \
 -DarchetypeVersion=1.9.3-SNAPSHOT \
 -DarchetypeGroupId=com.github.manolo \
 -DgroupId=com.example \
 -DartifactId=pwa-app \
 -DprojectName=MyPwaApp \
 -Dpackage=com.example.pwa \
```
                       
#### Compiling and running your project         

- Change to the project folder.
  - To build the PWA version of the application, run:

            $ mvn clean package -Ppwa 

  - To build the classic GWT package execute:

            $ mvn clean package
            
-  In both cases you will get a `.war` file ready for deploy in the `target` folder.

- To run the application in development mode run:

        $ mvn gwt:devmode
