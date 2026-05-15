$ErrorActionPreference = "Stop"

# Define roots
$srcMain = "c:\Users\eu mesmo\Desktop\trabalhos\antigravity\hamburgueria\src\main\java\burgergof"
$srcTest = "c:\Users\eu mesmo\Desktop\trabalhos\antigravity\hamburgueria\src\test\java\burgergof\test"
$newMain = "c:\Users\eu mesmo\Desktop\trabalhos\antigravity\hamburgueria\main"
$newTest = "c:\Users\eu mesmo\Desktop\trabalhos\antigravity\hamburgueria\tests"

# Move directories
Move-Item -Path $srcMain -Destination $newMain -Force
Move-Item -Path $srcTest -Destination $newTest -Force

# We need to process all Java files to update packages and imports
$allFiles = Get-ChildItem -Path $newMain, $newTest -Filter *.java -Recurse

foreach ($file in $allFiles) {
    $content = Get-Content -Path $file.FullName -Raw
    
    # Remove 'burgergof.' from packages and imports.
    # We replace 'package burgergof.something;' with 'package something;'
    # We replace 'package burgergof;' with nothing? Wait, Main.java is in burgergof.
    # If Main.java is in burgergof, its package was 'package burgergof;'
    # If we remove burgergof, Main.java will be in default package, so we remove the package line.
    
    # Replace package burgergof.something; -> package something;
    $content = $content -replace "package burgergof\.([^;]+);", "package `$1;"
    # Replace import burgergof.something; -> import something;
    $content = $content -replace "import burgergof\.([^;]+);", "import `$1;"
    
    # Replace package burgergof; -> // default package
    $content = $content -replace "package burgergof;", ""
    # Replace package burgergof.test; -> // default package (for tests if they are not in subfolders)
    # Wait, the tests were in burgergof.test. So package burgergof.test; should be removed!
    $content = $content -replace "package burgergof\.test;", ""
    
    Set-Content -Path $file.FullName -Value $content -Encoding UTF8
}

Write-Host "Done!"
