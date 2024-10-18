"""
    Made By Abdullah Alojado
    This is a program that uses the vigenere cypher to encrypt or decrypt text.

    The Vigenère cipher is a method of encrypting alphabetic text by 
    using a simple form of polyalphabetic substitution. 
    The cipher employs a key (a word or phrase) to shift letters of the plaintext.
"""

"""
    Function "encrypt":
        accepts:
            text: str (text to be encrypted)
            key: str (key used to encrypt)
        returns:
            result: str (encrypted text)
            
    This is a function that encrypts text using the vigenere cypher. 
    It accepts lowercase characters for both arguments.
"""
def encrypt(text: str, key: str) -> str:
    # Result to be returned.
    result = ""
    
    # Iterates through each char and its index in the text.
    for i, char in enumerate(text):
        # If its a letter, encrypt using the vigenere cypher,
        # Else keep the character.
        if char.isalpha():
            # Current key character to shift towards.
            currentKey = key[i % len(key)]
            # Get the shift amount.
            shift = ord(currentKey) - ord('a')
            # Get the shifted character
            char = chr((ord(char) + shift) % ord('z'))
            # Adds the character to the result.
            result += char            
        else:
            # Adds the unmodified character to the result.
            result += char
    
    # Return the result.
    return result

"""
    Function "decrypt":
        accepts:
            text: str (text to be decrypted)
            key: str (key used to decrypt)
        returns:
            result: str (decrypted text)
            
    This is a function that decrypts vigenere encyphered text. 
    It accepts lowercase characters for both arguments.
"""
def decrypt(text: str, key: str) -> str:
    # Result to be returned.
    result = ""
    
    # Number of letters
    # number of letters
    numberOfLetters = 26
    
    # Iterates through each char and its index in the text.
    for i, char in enumerate(text):
        # If its a letter, decrypt using the vigenere cypher,
        # Else keep the character.
        if char.isalpha():
            # Current key character to shift from.
            currentKey = key[i % len(key)]
            # Get the shift amount.
            shift = ord(currentKey) - ord('a')
            # Get the shifted character
            char = chr(ord('a') + (ord(char) - shift + numberOfLetters - ord('a')) % numberOfLetters)
            
            # Adds the character to the result.
            result += char            
        else:
            # Adds the unmodified character to the result.
            result += char
    
    # Return the result.
    return result

def run() -> None:
    print("Welcome to the vigenere cypher program!")
    # While loop that runs until the user enters 'e' or 'd'
    while True:
        # Ask user whether to encrypt or decrypt
        choice = input("Enter 'e' to encrypt or 'd' to decrypt: \n-> ").lower()
        if choice not in ['e', 'd']:
            print("Invalid choice. Please enter 'e' or 'd'.")
            continue
        break
    
    # Display appropriate string for encryption/decryption
    choiceLongString = "encrypt" if choice == 'e' else "decrypt"
    
    # While loop that runs until the user enters a positive integer.
    while True:
        # Ask user for the shift value and validate the input
        key = input("Enter key (must all be letters): \n-> ")
        if key.isalpha():
            key = key.lower()
            break
        print("Invalid key. Please input a value with all letters.")
    
    # Get the string to encrypt or decrypt and make it all lowercase.
    string = input(f"Enter string to {choiceLongString}: \n-> ").lower()
    
    # Perform the encryption or decryption.
    result = encrypt(string, key) if choice == 'e' else decrypt(string, key)
    
    # Output the result.
    print(f"\nResult: {result}\n")

if __name__ == '__main__':
    # Run the program
    run()
    