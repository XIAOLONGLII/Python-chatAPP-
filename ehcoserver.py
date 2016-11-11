import socket
import sys

sock=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
port=10000

server_address=('localhost',port)
print('It is listening on  providing reliable delivery to and statrts a loop listening on that socket' )
sock.bind(server_address)

#sock.listen(1)


#LOSS_RATE = 0.25
#AVERAGE_DELAY = 150

#random.seed(seed)

#delay = (random.random() * 2 * AVERAGE_DELAY) # sleep time in ms
#time.sleep(delay/1000.0) # accepts time in secs 

#if random.random() < LOSS_RATE 

while True:
    print('waiting for a connection')
    connection, client_address=sock.accept()

    try:
        print('connection from')

        while True:
            data=connection.recv(16)
            print('receied')

            if data:
                print>>sys.stderr,'sending data back to the client'
                connection.sendall(data)
            else:
                print>>sys.stderr,'no more data from',client_address
                break
    finally:
        connection.close()
