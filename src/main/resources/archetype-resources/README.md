## ${projectName} 

A GWT Progressive Web Application (PWA).

It uses `gwt-polymer-elements` for the UI elements and `


### Creating the Package

- Assuming you have installed maven, compile and package the project just running:

        $ mvn clean package -Ppwa
   
- If you want to produce the classic GWT version without service workers run:

        $ mvn clean package
    
### Developers   

To run the project in development mode run:

     $ mvn gwt:devmode
   
Then point your browser to http://localhost:8888/

### Eclipse

 The archetype generates a project ready to be used in eclipse, 

 Then you can import the project in your eclipse workspace:

    * File -> Import -> Existing Maven Projects


