from SimpleXMLRPCServer import SimpleXMLRPCServer
from SimpleXMLRPCServer import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Create server
server = SimpleXMLRPCServer(("localhost", 8000), requestHandler=RequestHandler)
server.register_introspection_functions()

server.register_function(pow)

def adder_function(x,y):
    return x + y
server.register_function(adder_function, 'add')

class MyFuncs:
    def div(self, x, y):
        return x // y

server.register_instance(MyFuncs())

server.serve_forever()
