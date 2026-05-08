# 🚀 AWS SNS Local CLI Cheatsheet (Parameterized)

This document contains parameterized AWS CLI commands to interact with Amazon SNS in a local environment (LocalStack / Floci).

---

## 🛠️ 1. Setup Variables
**Set TOPIC_NAME** by yourself, then run this block first in your terminal (Git Bash, Zsh, Bash):

```bash
# 🔑 Credentials for LocalStack
export AWS_ACCESS_KEY_ID=test
export AWS_SECRET_ACCESS_KEY=test
export AWS_DEFAULT_REGION=us-east-1

# 🌐 Infrastructure Configuration
export LOCAL_ENDPOINT="http://localhost:4566"
export AWS_REGION="us-east-1"

# 📢 SNS Topic Configuration
export TOPIC_NAME="pack-pub-sub"
export TOPIC_ARN="arn:aws:sns:$AWS_REGION:000000000000:$TOPIC_NAME"

# Verify
echo "Endpoint:    $LOCAL_ENDPOINT"
echo "Region:      $AWS_REGION"
echo "Topic Name:  $TOPIC_NAME"
echo "Topic ARN:   $TOPIC_ARN"
```

---

## 📝 2. Topic Operations

### List Topics

```bash
aws --endpoint-url $LOCAL_ENDPOINT sns list-topics \
  --region $AWS_REGION
```

## 🔔 3. Subscription Management

### List Subscriptions

```bash
aws --endpoint-url $LOCAL_ENDPOINT sns list-subscriptions-by-topic \
  --topic-arn $TOPIC_ARN \
  --region $AWS_REGION
```

---

## ✉️ 4. Publish Message

```bash
aws --endpoint-url $LOCAL_ENDPOINT sns publish \
  --topic-arn $TOPIC_ARN \
  --message "{\"eventId\": \"evt-1024\", \"status\": \"BROADCASTED\", \"service\": \"recording-service\"}" \
  --region $AWS_REGION
```

---

## 💡 Tips

* Ensure MiniStack is running and healthy (`curl -s "$LOCAL_ENDPOINT/_ministack/health"`)
* Check SQS policy to allow SNS to send messages
* Inspect MiniStack logs if messages are not delivered

---

## ✅ Quick Flow

```bash
# 1. Setup
# 2. Create topic
# 3. Subscribe SQS
# 4. Publish message
```
