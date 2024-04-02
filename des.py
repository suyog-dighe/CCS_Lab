from Crypto.Cipher import DES
from secrets import token_bytes
key = token_bytes(8)

nonce, ciphertext, tag = encrypt(input('Enter a String: '))

plaintext = decrypt(nonce, ciphertext, tag)

print(f'Cipher text: {ciphertext}')

if not plaintext:
    print('corrupted!')
else:
    print(f'Plain text: {plaintext}')