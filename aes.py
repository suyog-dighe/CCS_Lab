from Crypto.Cipher import AES
key=b'@#hdfegsgcfgfd33'
cipher=AES.new(key,AES.MODE_EAX)
data="welcome to sanjivani".encode()
nonce=cipher.nonce
ciphertext=cipher.encrypt(data)
print("Cipher text : ",ciphertext)
cipher=AES.new(key,AES.MODE_EAX,nonce=nonce)
plaintext=cipher.decrypt(ciphertext)
print("plaintext : ",plaintext)
