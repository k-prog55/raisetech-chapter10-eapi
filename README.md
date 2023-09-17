# 外部APIから住所を取得
## 概要
- **郵便番号をもとに外部APIにアクセス**し、**住所情報を取得**するコードを作成
- 外部APIは[zipcloud](http://zipcloud.ibsnet.co.jp/doc/api)を使用

## 動作確認結果
- 郵便番号を指定してリクエストを行い、正しく住所がレスポンスされたことを確認できた。
![スクリーンショット 2023-09-17 16 22 31](https://github.com/k-prog55/raisetech-chapter10-eapi/assets/138343132/8e573f90-a615-4aeb-a582-b7b500faa8a1)
- 郵便番号にエラー（６文字）があった場合、エラーがレスポンスされる例外処理を確認できた
![スクリーンショット 2023-09-17 16 29 26](https://github.com/k-prog55/raisetech-chapter10-eapi/assets/138343132/fedc3a14-9747-4446-9172-5dc2572582fe)
以上
