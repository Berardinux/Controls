import pigpio
import time

# Initialize pigpio
pi = pigpio.pi()

# Define GPIO pins
input_pin1 = 14
output_pin1 = 23
input_pin2 = 15
output_pin2 = 24

# Set GPIO input pins
pi.set_mode(input_pin1, pigpio.INPUT)
pi.set_mode(input_pin2, pigpio.INPUT)

# Set GPIO output pins
pi.set_mode(output_pin1, pigpio.OUTPUT)
pi.set_mode(output_pin2, pigpio.OUTPUT)

# Initialize the states of the output pins
output1_state = 0
output2_state = 0

# Set initial state for output pins
pi.write(output_pin1, output1_state)
pi.write(output_pin2, output2_state)

try:
    while True:
        # Read the state of input pins
        input1_state = pi.read(input_pin1)
        input2_state = pi.read(input_pin2)
        
        # Check input 1 state
        if input1_state == 1:
            output1_state = 1
            output2_state = 0
        
        # Check input 2 state
        if input2_state == 1:
            output2_state = 1
            output1_state = 0

        # Update the output pins based on states
        pi.write(output_pin1, output1_state)
        pi.write(output_pin2, output2_state)
        
        # Print the states for debugging
        print(f"Input 1: {'High' if input1_state else 'Low'} -> Output 1: {'High' if output1_state else 'Low'}")
        print(f"Input 2: {'High' if input2_state else 'Low'} -> Output 2: {'High' if output2_state else 'Low'}")
        
        # Sleep for a short time to avoid spamming the output
        time.sleep(0.1)
        
except KeyboardInterrupt:
    # Clean up and stop the pigpio library
    pi.stop()
