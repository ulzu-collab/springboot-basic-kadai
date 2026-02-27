let maxDate = new Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);	// 変数に3か月後の日付を代入。

flatpickr('#fromCheckinDateToCheckoutDate', {	// HTML要素にFlatpickrのインスタンスを生成。
	mode: "range",
	locale: 'ja',
	minDate: 'today',
	maxDate: maxDate,
	onClose: function(selectedDates, dateStr, instance) {	// カレンダーの設定。
		const dates = dateStr.split(" から ");
		if (dates.length === 2) {
			document.querySelector("input[name='checkinDate']").value = dates[0];
			document.querySelector("input[name='checkoutDate']").value = dates[1];
		} else {
			document.querySelector("input[name='checkinDate']").value = '';
			document.querySelector("input[name='checkoutDate']").value = '';
		}
	}
});