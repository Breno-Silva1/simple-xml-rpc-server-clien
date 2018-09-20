# rabbit-mom

Para executar o servidor do *rabbitmq* você pracisará instala-lo primeiramente, [link aqui] (https://www.rabbitmq.com/install-debian.html#downloads) .

E da biblioteca do *Pika*.

```sh
pip install pika
```
ou 

```sh
easy_install pika
```
Para executar o servidor, caso necessário.

```sh
easy_install pika
```

Para verificar as filas e a quantidade de mensagens que estão salvas.

```sh
sudo rabbitmqctl list_queues
```

E executar os códigos *Python*.

#### send.py
```python
#!/usr/bin/env python
import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()


channel.queue_declare(queue='hello')

channel.basic_publish(exchange='',routing_key='hello', body='Hello World!')
channel.basic_publish(exchange='',routing_key='hello', body='Hello Again!')

channel.queue_declare(queue='eai')
channel.basic_publish(exchange='',routing_key='eai', body='Vai encarar?!')

print("Sent Messages...")
connection.close()
```

#### receive.py
```python
#!/usr/bin/env python
import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()


channel.queue_declare(queue='hello')
channel.queue_declare(queue='eai')

def callback(ch, method, properties, body):
    print(" [x] Received %r" % body)

channel.basic_consume(callback, queue='hello', no_ack=True)
channel.basic_consume(callback, queue='eai', no_ack=True)

print(' [*] Waiting for messages. To exit press CTRL+C')
channel.start_consuming()
```
