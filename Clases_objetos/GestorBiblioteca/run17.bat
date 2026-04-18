@echo off
echo Compilando con JDK 17...
"C:\Program Files\Java\jdk-17\bin\javac" */*.java
if %ERRORLEVEL% neq 0 (
  echo ❌ Error de compilación
  pause
  exit /b
)
echo ✅ Ejecutando...
"C:\Program Files\Java\jdk-17\bin\java" consola.Main
pause
