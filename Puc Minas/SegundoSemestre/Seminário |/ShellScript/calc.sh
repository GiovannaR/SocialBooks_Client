if [ $1 = "+" ]; then
SUM=$2
for VAR in $3 $4 $5 $6 $7 $8 $9; do
SUM=$(($SUM + $VAR ))
done
echo $SUM 
fi
if [ $1 = "-" ]; then
MENOS=$2
for VAR in $3 $4 $5 $6 $7 $8 $9; do
MENOS=$(($MENOS - $VAR ))
done
echo $MENOS
fi
if [ $1 = "p" ]; then
MULT=$2
for VAR in $3 $4 $5 $6 $7 $8 $9; do
MULT=$(($MULT \* $VAR ))
done
echo $MULT
fi
if [ $1 = "d" ]; then
DIV=$2
for VAR in $3 $4 $5 $6 $7 $8 $9; do
DIV=$(($DIV / $VAR ))
done
echo $DIV
fi

