clear
cd Practico3
printf "Compiling..."
javac -d bin src/consola/*.java src/logica/*.java
if [ $? == 0 ] 
then
    clear
    java -cp bin consola.Principal_Art
else
    printf "\n\n\nError - Exit code $?"
fi

