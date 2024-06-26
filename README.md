# kfriday-interview
입출고 CRUD API 서버 입니다.

- 저희는 물류 업무를 하고 있습니다. 입출고 되는 패키지(package)의 데이터 구조가 아래와 같을 때, 이 패키지에 대한 CRUD API 서버를 구성해주세요. 인증은 고려하지 않으셔도 됩니다.
- 작업물 제출은 github 등 편한 방법으로 해주시면 됩니다.

```
{
    "id": 1,
    "trackingNo": 111122223333,
    "images": [
        {
            filename: "image1.png",
            type: "PKG"
        },
        {
            filename: "image2.png",
            type: "PKG"
        },
    ]
}
```

## ERD

![Untitled](https://github.com/DEVdongbaek/kfriday-project/assets/74356213/a3774427-a55b-44a6-bc4f-42b89fc3e4cc)

## Swagger URL

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## H2 데이터베이스 콘솔

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)
