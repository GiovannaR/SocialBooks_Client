#!/bin/sh
mkdir BackUP
if [ -d "$1" ]; then
cp -r "$1" ./BackUP
echo 'Copia feita'
else 
echo 'Falha'
fi

