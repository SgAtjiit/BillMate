@echo off
echo Compiling...
javac -cp "lib/itextpdf-5.5.13.3.jar;src" -d bin "src\com\billing\system\model\*.java" "src\com\billing\system\repository\*.java" "src\com\billing\system\strategy\*.java" "src\com\billing\system\service\*.java" "src\com\billing\system\ui\*.java" "src\com\billing\system\Main.java"

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful. Running application...
    java -cp "bin;lib/itextpdf-5.5.13.3.jar" com.billing.system.Main
) else (
    echo Compilation failed.
    pause
)
