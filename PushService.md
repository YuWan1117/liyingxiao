# PushService

## 下面的例子中所使用到的常量解释：(变量名称/含义)

|   Variable          | Meanings  |
| :------------------ | :------------------------------------|
|   $appId            |   小米开放平台申请的AppId              |
|   $appKey           |   小米开放平台申请的AppKey             |
|   $appSecret        |   小米开放平台申请的AppSecret	        |
|   $fromAccount      |   表示消息发送方成员号account(app账号)  |
|   $fromResource     |   表示用户设备的标识                   |
|   $toAccount        |   表示消息接收方成员号account(app账号)  |
|   $msgType          |   表示发送消息的类型(msgType="base64":msg是base64编码后的数据，一般传输二进制数据时使用; msgType="":msg是原始数据，一般传输String数据时使用) |
|   $topicId			 		|   表示群ID                             |
|   $packetId         |  表示发送消息包ID                     |


## 1） 推送单聊信息

+ HTTP 请求
```
curl https://mimc.chat.xiaomi.net/api/push/p2p/ -XPOST -d '{"appId":$appId, "appKey":$appKey，"appSecret":$appSecret, "fromAccount":$fromAccount, "fromResource":$fromResource, "toAccount":$toAccount, "msg":$msg, "msgType":$msgType}' -H "Content-Type: application/json"
```

+ JSON结果
```
{
	"code":200,
	"data":{"packetId":$packetId},
	"message":"success"
}
```

## 2）推送群聊信息

+ HTTP 请求
```
curl https://mimc.chat.xiaomi.net/api/push/p2t/ -XPOST -d '{"appId":$appId, "appKey":$appKey，"appSecret":$appSecret, "fromAccount":$fromAccount, "fromResource":$fromResource, "msg":$msg, "topicId":$topicId, "msgType":$msgType}' -H "Content-Type: application/json"
```

+ JSON结果
```
{
	"code":200,
	"data":{"packetId":$packetId},
	"message":"success"
}
