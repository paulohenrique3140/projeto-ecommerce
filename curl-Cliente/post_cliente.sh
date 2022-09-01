echo "Nome:"
read NOME
echo "E-mail:"
read EMAIL 
echo "Senha:"
read SENHA
echo "rg:"
read RG
echo "cpf:"
read CPF

curl -d  "{ \"nome\": \"$NOME\", \"email\": \"$EMAIL\", \"senha\": \"$SENHA\", \"rg\": \"$RG\", \"cpf\": \"$CPF\"} " -H "Content-Type: application/json" -X POST localhost:8080/clientes

