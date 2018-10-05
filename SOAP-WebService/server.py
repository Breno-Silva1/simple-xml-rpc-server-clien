from SOAPpy import SOAPServer

def calcula(n1,n2,operacao):
        if operacao == 'soma':
                return n1 + n2
        if operacao == 'sub':
                return n1 - n2
        if operacao == 'mult':
                return n1 * n2
        if operacao == 'div':
                return n1 / n2
server = SOAPServer(('localhost',8081))
server.registerFunction(calcula)
server.serve_forever()
