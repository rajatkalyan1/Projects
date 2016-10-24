from twilio.rest import TwilioRestClient

account_sid = "fffffffffff" # Your Account SID from www.twilio.com/console
auth_token  = "eeeeeeeeeee"  # Your Auth Token from www.twilio.com/console

client = TwilioRestClient(account_sid, auth_token)

message = client.messages.create(body="Hello from Python",
    to="+12222222222",    # Replace with your phone number
    from_="+12222222222") # Replace with your Twilio number

print(message.sid)
