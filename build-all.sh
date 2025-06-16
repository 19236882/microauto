#!/bin/bash

MODULES=("client" "gestionlocation" "gestionvehicules")

for module in "${MODULES[@]}"; do
  echo "🔨 Compilation du module: $module"
  cd "$module" || { echo "❌ Dossier $module introuvable"; exit 1; }

  if [ -f "pom.xml" ]; then
    mvn clean install -DskipTests -Dsonar.skip=true
    [ $? -ne 0 ] && { echo "❌ Échec dans le module: $module"; exit 1; }
  else
    echo "⚠️ Aucun pom.xml dans $module, on saute..."
  fi

  cd ..
done

echo "✅ Tous les modules compilés avec succès"
