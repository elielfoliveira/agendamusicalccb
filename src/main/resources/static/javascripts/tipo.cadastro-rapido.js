$(function() {
	
	var modal = $('#modalCadastroRapidoEstilo'); // obtém o id do cadastro rápido
	var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn'); // Obtém o botão salvar do cadastro rápido e o guarda 
	var form = modal.find('form');
	form.on('submit', function(event) { event.preventDefault() }); // Se pressionar <enter> no cadastro rápido, ele não é submetido
	var url = form.attr('action'); // Obtêm o atributo action do formulário
	var inputDescricaoTipo = $('#nomeEstilo');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose)
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		inputDescricaoTipo.focus();
	}
	
	function onModalClose() {
		inputDescricaoTipo.val('');
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick() {
		var descricaoTipo = inputDescricaoTipo.val().trim();
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ descricao: descricaoTipo }),
			error: onErroSalvandoTipo,
			success: onTipoSalvo
		});
	}
	
	function onErroSalvandoTipo(obj) {
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onTipoSalvo(tipo) {
		var comboTipo = $('#tipo');
		comboTipo.append('<option value=' + tipo.id + '>' + tipo.descricao + '</option>');
		comboTipo.val(tipoido);
		modal.modal('hide');
	}
	
});
