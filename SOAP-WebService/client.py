from SOAPpy import SOAPProxy

server = SOAPProxy('http://localhost:8081/')
n1  = input("n1: ")
n2  = input("n2: ")
opc = raw_input("operacao: ")
print 'resultado = ' + str(server.calcula(n1,n2,opc))
