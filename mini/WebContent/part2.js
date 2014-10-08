"use strict"; 


function Board( name, score) {
	this.name = name;
	this.score = score;
}

var boardList = [];

$('#btnAdd').click(function(event) {
	var board = new Board(
			
			$('#name').val(),
			$('#score').val()
			
			);

	boardList.push(board);
    
	refreshBoardList();
});


function refreshBoardList() {
	var boardTable = $('#boardTable');

	$('.dataRow').remove();
	for (var i in boardList) {
		$('<tr>')
			.appendTo(boardTable)
			.attr('class', 'dataRow')
			.append($('<td>').html(parseInt(i)+1))
			
			.append($('<td>').html(boardList[i].name))

			.append($('<td>').html(boardList[i].score));
			
	}
}


