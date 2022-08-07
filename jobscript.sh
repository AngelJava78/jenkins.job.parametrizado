#!/bin/bash
echo "Bienvenido/a al planeta $planeta"
if [ "$agente" = "true" ]
then
	echo "Prepárese para la misión agente X, que la fuerza te acompañe."
else
	echo "Disfruta el planeta humano/a $nombre, trata de no morir."
fi
if [ $age >= 18 ]
then
    echo "Eres mayor de edad. Edad: $age"
else
    echo "Eres menor de edad. Edad: $age"
fi 
echo "..."
sleep 10
echo "¡Suerte! La necesitarás."