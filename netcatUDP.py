import socket

port= 42425
host="localhost"
listenerport=42424


s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
s.bind((host,port))

#msg,addr=s.recieve(1024)



stringbuf = ""
for i in range (0, 1000):
    stringbuf=stringbuf+ "spam_"+str(i)+"\n"
    

buf= stringbuf.encode("utf-8")

s.sendto(buf,(host,listenerport))
#sentot() dgram

s.close()

