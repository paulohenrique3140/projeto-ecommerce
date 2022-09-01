echo "Nome do departamento:"
read NOME
echo "Descrição do departamento:"
read DESCRICAO

curl -d "{ \"nome\": \"$NOME\", \"descricao\": \"$DESCRICAO\"  }" -H "Content-Type: application/json" -X POST localhost:8080/departamentos