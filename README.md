# simple-xml-rpc-server-clien
Aplicação simples de RPC para _mostrar a data e hora de hoje_, comunicando-se por XML, implementado em Python.

### server.py

```python
import datetime
from SimpleXMLRPCServer import SimpleXMLRPCServer
import xmlrpclib

def today():
    today = datetime.datetime.today()
    return xmlrpclib.DateTime(today)

server = SimpleXMLRPCServer(("localhost", 8000))
print "Listening on port 8000..."
server.register_function(today, "today")
server.serve_forever()
```


### client.py

```python
import xmlrpclib
import datetime

proxy = xmlrpclib.ServerProxy("http://localhost:8000/")
today = proxy.today() 
converted = datetime.datetime.strptime(today.value, "%Y%m%dT%H:%M:%S") 
print "Today: %s" % converted.strftime("%d.%m.%Y, %H:%M") 
```
