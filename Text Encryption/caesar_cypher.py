"""
    Made By Abdullah Alojado
    This is a program that uses the caesar cypher to encrypt or decrypt text.

    The Caesar cipher is a simple encryption technique where each letter 
    in a given text is replaced by a letter a fixed number of positions down or up the alphabet. 
    It is a type of substitution cipher and is named after Julius Caesar, 
    who reportedly used it to communicate with his officials.
"""

"""
    Function "encrypt":
        accepts:
            text: str (text to be encrypted)
            shift: int (shift used to encrypt)
        returns:
            result: str (encrypted text)
            
    This is a function that encrypts text using the caesar cypher. 
"""
def encrypt(text: str, shift: int) -> str:
    # Result to be returned.
    result = ""
    
    # For each character in the text,
    for char in text:
        # If it's a letter, encrypt using the shift index.
        # Else, keep the unchanged character.
        
        if char.isalpha():
            # Determine the ASCII offset based on whether the letter is uppercase or lowercase
            ascii_offset = ord('a') if char.islower() else ord('A')
            # Perform the encryption by shifting the character within the alphabet
            encrypted_char = chr((ord(char) - ascii_offset + shift) % 26 + ascii_offset)
            # Add the encrypted character to the result
            result += encrypted_char
        else:
            # Keep the non-letter character and add it to the result.
            result += char
    
    # Return the result.
    return result

"""
    Function "decrypt":
        accepts:
            text: str (text to be decrypted)
            shift: int (shift used to decrypt)
        returns:
            result: str (decrypted text)
            
    This is a function that decrypts caesar cyphered text to plaintext. 
"""
def decrypt(text: str, shift: int) -> str:
    # Result to be returned.
    result = ""
    
    # For each char in the text,
    for char in text:
        if char.isalpha():
            # Determine the ASCII offset based on whether the letter is uppercase or lowercase.
            ascii_offset = ord('a') if char.islower() else ord('A')
            # Perform the decryption by reversing the shift.
            decrypted_char = chr((ord(char) - ascii_offset - shift) % 26 + ascii_offset)
            # Add the decrypted character to the result.
            result += decrypted_char
        else:
            # Keep non-alphabet characters unchanged.
            result += char
            
    # Return the result.
    return result

def run() -> None:
    print("Welcome to the caesar cypher program!")
    
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
        shift = input("Enter shift (must be a non-negative integer): \n-> ")
        if shift.isnumeric() and int(shift) >= 0:
            shift = int(shift)
            break
        print("Invalid shift. Please enter a non-negative integer.")
    
    # Get the string to encrypt or decrypt
    string = input(f"Enter string to {choiceLongString}: \n-> ")
    
    # Perform the encryption or decryption
    result = encrypt(string, shift) if choice == 'e' else decrypt(string, shift)
    
    # Output the result
    print(f"\nResult: {result}\n")

if __name__ == '__main__':
    # Run the program
    run()
    