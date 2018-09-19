# pyro-naming-service

Para executar o servidor de nome do *Pyro* é necessário baixa-lo inicialmente.

#### Ubuntu
```sh
sudo apt-get update
sudo apt-get install pyro
```

Depois é só executa-lo
```sh
pyro-ns
```

E executar os códigos *Python*.

#### server.py
```python
import Pyro.core

class JokeGen(Pyro.core.ObjBase):
		def __init__(self):
                Pyro.core.ObjBase.__init__(self)
        def joke(self, name):
                return "Sorry "+name+", I don't know any jokes."

def main():
	Pyro.core.initServer()
    daemon=Pyro.core.Daemon()
    uri=daemon.connect(JokeGen(),"jokegen")

    print "The daemon runs on port:",daemon.port
    print "The object's uri is:",uri

    daemon.requestLoop()
    
if __name__=="__main__":
    main()
```

#### client.py
```python
import Pyro.core

# you have to change the URI below to match your own host/port.
jokes = Pyro.core.getProxyForURI("PYROLOC://localhost:7766/jokegen")

print jokes.joke("Breno")
```
