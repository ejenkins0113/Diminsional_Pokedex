$ErrorActionPreference = "Stop"

Set-Location $PSScriptRoot

if (-not (Test-Path "out")) {
    New-Item -ItemType Directory -Path "out" | Out-Null
}

$sources = Get-ChildItem -Recurse "src" -Filter *.java | ForEach-Object { $_.FullName }
if (-not $sources -or $sources.Count -eq 0) {
    throw "No Java source files were found under src/."
}

Write-Host "Compiling Java sources..."
& javac -d "out" $sources
if ($LASTEXITCODE -ne 0) {
    throw "Compilation failed."
}

Write-Host "Starting Dimensional Dex..."
& java -cp "out" ui.MainMenu
