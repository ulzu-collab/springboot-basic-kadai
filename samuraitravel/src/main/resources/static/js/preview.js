const imageInput = document.getElementById('imageFile');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', () => {
	// imageFileが指定されているHTML要素の値が変更された時にイベント処理を実行する。
	if (imageInput.files[0]) {
		let fileReader = new FileReader();
		fileReader.onload = () => {
			imagePreview.innerHTML = `<img src="${fileReader.result}" class="mb-3">`;
		}
		fileReader.readAsDataURL(imageInput.files[0]);
	} else {
		// 指定された画像ファイルが無い場合はHTML要素の中身を空にする。
		imagePreview.innerHTML = '';
	}
})