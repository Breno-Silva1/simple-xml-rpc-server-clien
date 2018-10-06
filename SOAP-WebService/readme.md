# SOAP-WebService (Python)

É necessário instalar o *SOAP Services for Python* <br>
* Download: https://pypi.org/project/SOAPpy/#files
* GitHub: https://github.com/kiorky/SOAPpy

l. Extraia os arquivos do .zip <br>
l. Entre na pasta extraída com *$ cd*<br>
l. Compile o pacote:<br>
```sh
$ sudo python setup.py build
```

l. Instale o pacote:<br>

```sh
$ sudo python setup.py install
```

### Um simples "Hello World":

#### server.py
```py
import SOAPpy
def hello():
    return "Hello World"
server = SOAPpy.SOAPServer(("localhost", 8080))
server.registerFunction(hello)
server.serve_forever()
```

#### client.py
```py
import SOAPpy
server = SOAPpy.SOAPProxy("http://localhost:8080/")
print server.hello()
```
