import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import random
import sys

def send_otp_email(sender_email, sender_password, recipient_email,Otp):
    # Email details
    subject = 'OTP Verification'
    message = f'Welcome to Toffee store\nYour OTP is: {Otp}'

    # Create the email message
    msg = MIMEMultipart()
    msg['From'] = sender_email
    msg['To'] = recipient_email
    msg['Subject'] = subject
    msg.attach(MIMEText(message, 'plain'))

    try:
        # Create a secure SSL connection to the SMTP server
        with smtplib.SMTP_SSL('smtp.gmail.com', 465) as server:
            # Login to the sender's email account
            server.login(sender_email, sender_password)
            # Send the email
            server.sendmail(sender_email, recipient_email, msg.as_string())
        print('OTP sent successfully.')
    except Exception as e:
        print('An error occurred while sending the OTP:', str(e))

if __name__ == '__main__':
    if len(sys.argv) < 5:
        print("Usage: python send_email.py sender_email sender_password recipient_email otp")
    else:
        sender_email = sys.argv[1]
        sender_password = sys.argv[2]
        recipient_email = sys.argv[3]
        otp = sys.argv[4]

        send_otp_email(sender_email, sender_password, recipient_email,otp)
