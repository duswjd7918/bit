"use strict"; 


function bit(value) {
	var elements = null;
	
	if (value instanceof Element) {
		elements = [value];
	} else if (value.charAt(0) == '<') { 
		elements = [document.createElement(value.replace(/<|>/g, ''))];	
	} else {
		elements = document.querySelectorAll(value);
	}


	elements.html = function(value) {
		for (var i = 0; i < this.length; i++) {
			this[i].innerHTML = value;
		}
		return this;
	};

	elements.append = function(child) {
		for (var i = 0; i < this.length; i++) {
			if (child instanceof Element) {
				this[i].appendChild(child);
			} else {
				for (var x = 0; x < child.length; x++) {
					this[i].appendChild(child[x]);
				}
			}
		}
		return this;
	};

	elements.appendTo = function(parent) {
		for (var i = 0; i < this.length; i++) {
			if (parent instanceof Element) {
				parent.appendChild(this[i]);
			} else {
				parent[0].appendChild(this[i]);
			}
		}
		return this;
	};

	elements.attr = function(name, value) {
		if (arguments.length == 2) {
			for (var i = 0; i < this.length; i++) {
				this[i].setAttribute(name, value);
			}
			return this;
		} else {
			return this[0].getAttribute(name);
		}
	};

	elements.click = function(listener) {
		for (var i = 0; i < this.length; i++) {
			if (listener) {
				this[i].onclick = listener;
			} else {
				var event = new MouseEvent('click', {
					'view': window,
					'bubbles': true,
					'cancelable': true
				});
				this[i].dispatchEvent(event);
			}
		}
		return this;
	}

	elements.val = function(value) {
		if (arguments.length == 1) {
			for (var i = 0; i < this.length; i++) {
				this[i].value = value;
			}
			return this;
		} else {
			return this[0].value;
		}
	};

	
	elements.remove = function() {
		for (var i = 0; i < this.length; i++) {
			this[i].parentElement.removeChild(this[i]);
		}
		return this;
	};
	

	return elements;
}

var $ = bit;


