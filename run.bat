@echo off
setlocal
echo Compiling BillMate...
if not exist bin mkdir bin
if not exist data mkdir data
if not exist generated_invoices mkdir generated_invoices

powershell -NoProfile -Command "$files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { '\"' + $_.FullName.Replace('\', '/') + '\"' }; Set-Content -Path sources.txt -Value $files"

javac -cp "lib/*;src" -d bin @sources.txt
if exist sources.txt del sources.txt

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful. Running BillMate...
    java -cp "bin;lib/*" com.billing.system.Main
) else (
    echo Compilation failed.
    pause
)
