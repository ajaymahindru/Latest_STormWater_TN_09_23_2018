
(function() {

			!function(){
				function t(t){this.el=t;for(var n=t.className.replace(/^\s+|\s+$/g,"").split(/\s+/),i=0;i<n.length;i++)e.call(this,n[i])}
				
				if(!("undefined"==typeof window.Element||"classList"in document.documentElement))
				{
					var i=Array.prototype,
					e=i.push,
					s=i.splice,
					o=i.join;t.prototype={add:function(t){this.contains(t)||(e.call(this,t),this.el.className=this.toString())},contains:function(t){return-1!=this.el.className.indexOf(t)},item:function(t){return this[t]||null},remove:function(t){if(this.contains(t)){for(var n=0;n<this.length&&this[n]!=t;n++);s.call(this,n,1),this.el.className=this.toString()}},toString:function(){return o.call(this," ")},toggle:function(t){return this.contains(t)?this.remove(t):this.add(t),this.contains(t)}},window.DOMTokenList=t,n(Element.prototype,"classList",function(){return new t(this)})}}();

		

		var	$body = document.querySelector('body');

		$body.classList.add('is-loading');

		window.addEventListener('load', function() {
			window.setTimeout(function() {
				$body.classList.remove('is-loading');
			}, 100);
		});

		(function() {

				var settings = {

						images: {
							'images/AJ01.jpg': 'center',
							'images/AJ02.jpg': 'center',
							'images/AJ03.jpg': 'center',
							'images/AJ04.jpg': 'center'
						},

						delay: 6000

				};


				var	gov = 0, lastgov = 0,
					$wrapper, $tns = [], $tn,
					k, v;

				$wrapper = document.createElement('div');
					$wrapper.id = 'tn';
					$body.appendChild($wrapper);

				for (k in settings.images) {


						$tn = document.createElement('div');
							$tn.style.backgroundImage = 'url("' + k + '")';
							$tn.style.backgroundgovition = settings.images[k];
							$wrapper.appendChild($tn);

						$tns.push($tn);

				}

				$tns[gov].classList.add('visible');
				$tns[gov].classList.add('top');

				window.setInterval(function() {

					lastgov = gov;
					gov++;
						if (gov >= $tns.length)
							gov = 0;
						$tns[lastgov].classList.remove('top');
						$tns[gov].classList.add('visible');
						$tns[gov].classList.add('top');

						window.setTimeout(function() {
							$tns[lastgov].classList.remove('visible');
						}, settings.delay / 2);

				}, settings.delay);

		})();

})();