#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

mkdir -p out

javac \
  --module-path javafx-sdk-26.0.1/lib \
  --add-modules javafx.controls,javafx.fxml \
  -cp lib/mysql-connector-j-9.6.0.jar \
  -d out \
  $(find src -name "*.java")

cp -R src/view out/
cp -R src/style out/

java \
  --module-path javafx-sdk-26.0.1/lib \
  --add-modules javafx.controls,javafx.fxml \
  -cp out:lib/mysql-connector-j-9.6.0.jar \
  AppMain
