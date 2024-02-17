#!/usr/bin/env bash
re=[^br]

echo "CHOOSE ONE OF THE OPTIONS BELLOW"
echo "[u] -> only build docker image"
echo "[b] -> clean install project and build docker image"
echo "[bp] -> <<option b>> then push to docker hub"
echo "[up] -> [option u] then push to docker hub"
echo "[p] -> push to docker hub"
echo "[q] -> quit"
read -r choice

if [[ $choice =~ $re ]]; then
  if [ $choice = q ]; then
    echo "see ya"
  else
    echo "I understand! Technology is not easy..."
  fi
  exit 0
else
  echo "Building java project"
  mvn clean install -DskipTests && mvn compile -DskipTests && mvn package -DskipTests
  echo "buildind docker image"
  docker build -t 3p1l/inaluma-api-anew:arm64-v8-1.0-beta .
  # echo "pushing docker image"
  # docker push 3p1l/inaluma-api-anew:arm64-v8-1.0-beta
fi
