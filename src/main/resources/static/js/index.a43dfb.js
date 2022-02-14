(function(d){var h=[];d.loadImages=function(a,e){"string"==typeof a&&(a=[a]);for(var f=a.length,g=0,b=0;b<f;b++){var c=document.createElement("img");c.onload=function(){g++;g==f&&d.isFunction(e)&&e()};c.src=a[b];h.push(c)}}})(window.jQuery);
var wl;

var lwi=-1;function thresholdPassed(){var w=$(window).width();var p=false;var cw=0;if(w>=480){cw++;}if(w>=768){cw++;}if(w>=960){cw++;}if(w>=1200){cw++;}if(lwi!=cw){p=true;}lwi=cw;return p;}
ldsrcset=function(t){var e,r=document.querySelectorAll(t);for(e=0;e<r.length;e++){var c=r[e].getAttribute("data-srcset");r[e].setAttribute("srcset",c)}},ldsrc=function(t){var e=document.querySelector(t),r=e.getAttribute("data-src");e.setAttribute("src",r)};shapesData={"shape1":[[],[],[],[0,20,87],[0,13,58]],"shape3":[[],[],[],[0,245,161,0,244,1,0,243,1,0,0,10,0,0,148],[0,163,108,0,0,7,0,0,99]],"shape2":[[],[],[],[0,16,109],[0,10,73]]};!function(){if("Promise"in window&&void 0!==window.performance){var e,t,r=document,n=function(){return r.createElement("link")},o=new Set,a=n(),i=a.relList&&a.relList.supports&&a.relList.supports("prefetch"),s=location.href.replace(/#[^#]+$/,"");o.add(s);var c=function(e){var t=location,r="http:",n="https:";if(e&&e.href&&e.origin==t.origin&&[r,n].includes(e.protocol)&&(e.protocol!=r||t.protocol!=n)){var o=e.pathname;if(!(e.hash&&o+e.search==t.pathname+t.search||"?preload=no"==e.search.substr(-11)||".html"!=o.substr(-5)&&".html"!=o.substr(-5)&&"/"!=o.substr(-1)))return!0}},u=function(e){var t=e.replace(/#[^#]+$/,"");if(!o.has(t)){if(i){var a=n();a.rel="prefetch",a.href=t,r.head.appendChild(a)}else{var s=new XMLHttpRequest;s.open("GET",t,s.withCredentials=!0),s.send()}o.add(t)}},p=function(e){return e.target.closest("a")},f=function(t){var r=t.relatedTarget;r&&p(t)==r.closest("a")||e&&(clearTimeout(e),e=void 0)},d={capture:!0,passive:!0};r.addEventListener("touchstart",function(e){t=performance.now();var r=p(e);c(r)&&u(r.href)},d),r.addEventListener("mouseover",function(r){if(!(performance.now()-t<1200)){var n=p(r);c(n)&&(n.addEventListener("mouseout",f,{passive:!0}),e=setTimeout(function(){u(n.href),e=void 0},80))}},d)}}();

$(function(){
r=function(){if(thresholdPassed()){dpi=window.devicePixelRatio;if($(window).width()>=1200){var e=document.querySelector('.un1');e.setAttribute('src',(dpi>1)?'images/pen2-310.png':'images/pen2-155.png');
var e=document.querySelector('.un3');e.setAttribute('src',(dpi>1)?'images/4-1200.jpg':'images/4-600.jpg');
var e=document.querySelector('.un4');e.setAttribute('src',(dpi>1)?'images/03-600.jpg':'images/03-300.jpg');
var e=document.querySelector('.un5');e.setAttribute('src',(dpi>1)?'images/10-600.jpg':'images/10-300.jpg');
var e=document.querySelector('.un6');e.setAttribute('src',(dpi>1)?'images/01-1200.jpg':'images/01-600.jpg');
var e=document.querySelector('.un7');e.setAttribute('src',(dpi>1)?'images/13-1200.jpg':'images/13-600.jpg');
var e=document.querySelector('.un8');e.setAttribute('src',(dpi>1)?'images/09-600.jpg':'images/09-300.jpg');
var e=document.querySelector('.un9');e.setAttribute('src',(dpi>1)?'images/05-592.jpg':'images/05-296.jpg');
var e=document.querySelector('.un10');e.setAttribute('src',(dpi>1)?'images/02-1200.jpg':'images/02-600.jpg');
var a='data-src';var e=document.querySelector('.un11');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/phone-920.jpg':'images/phone-460.jpg');
var a='data-src';var e=document.querySelector('.un12');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/mail-156.jpg':'images/mail-78.jpg');}else if($(window).width()>=960){var e=document.querySelector('.un1');e.setAttribute('src',(dpi>1)?'images/pen2-248.png':'images/pen2-124.png');
var e=document.querySelector('.un3');e.setAttribute('src',(dpi>1)?'images/4-960.jpg':'images/4-480-1.jpg');
var e=document.querySelector('.un4');e.setAttribute('src',(dpi>1)?'images/03-480.jpg':'images/03-240-1.jpg');
var e=document.querySelector('.un5');e.setAttribute('src',(dpi>1)?'images/10-480.jpg':'images/10-240-1.jpg');
var e=document.querySelector('.un6');e.setAttribute('src',(dpi>1)?'images/01-960.jpg':'images/01-480-1.jpg');
var e=document.querySelector('.un7');e.setAttribute('src',(dpi>1)?'images/13-960.jpg':'images/13-480-1.jpg');
var e=document.querySelector('.un8');e.setAttribute('src',(dpi>1)?'images/09-480.jpg':'images/09-240-1.jpg');
var e=document.querySelector('.un9');e.setAttribute('src',(dpi>1)?'images/05-474.jpg':'images/05-237.jpg');
var e=document.querySelector('.un10');e.setAttribute('src',(dpi>1)?'images/02-960.jpg':'images/02-480-1.jpg');
var a='data-src';var e=document.querySelector('.un11');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/phone-736.jpg':'images/phone-368.jpg');
var a='data-src';var e=document.querySelector('.un12');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/mail-126.jpg':'images/mail-63.jpg');}else if($(window).width()>=768){var e=document.querySelector('.un1');e.setAttribute('src',(dpi>1)?'images/pen2-198.png':'images/pen2-99.png');
var e=document.querySelector('.un3');e.setAttribute('src',(dpi>1)?'images/4-768.jpg':'images/4-384.jpg');
var e=document.querySelector('.un4');e.setAttribute('src',(dpi>1)?'images/03-384.jpg':'images/03-192.jpg');
var e=document.querySelector('.un5');e.setAttribute('src',(dpi>1)?'images/10-384.jpg':'images/10-192.jpg');
var e=document.querySelector('.un6');e.setAttribute('src',(dpi>1)?'images/01-768.jpg':'images/01-384.jpg');
var e=document.querySelector('.un7');e.setAttribute('src',(dpi>1)?'images/13-768.jpg':'images/13-384.jpg');
var e=document.querySelector('.un8');e.setAttribute('src',(dpi>1)?'images/09-384.jpg':'images/09-192.jpg');
var e=document.querySelector('.un9');e.setAttribute('src',(dpi>1)?'images/05-380.jpg':'images/05-190.jpg');
var e=document.querySelector('.un10');e.setAttribute('src',(dpi>1)?'images/02-768.jpg':'images/02-384.jpg');
var a='data-src';var e=document.querySelector('.un11');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/phone-588.jpg':'images/phone-294.jpg');
var a='data-src';var e=document.querySelector('.un12');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/mail-100.jpg':'images/mail-50.jpg');}else if($(window).width()>=480){var e=document.querySelector('.un1');e.setAttribute('src',(dpi>1)?'images/pen2-442.png':'images/pen2-221.png');
var e=document.querySelector('.un3');e.setAttribute('src',(dpi>1)?'images/4-480.jpg':'images/4-240.jpg');
var e=document.querySelector('.un4');e.setAttribute('src',(dpi>1)?'images/03-240.jpg':'images/03-120.jpg');
var e=document.querySelector('.un5');e.setAttribute('src',(dpi>1)?'images/10-240.jpg':'images/10-120.jpg');
var e=document.querySelector('.un6');e.setAttribute('src',(dpi>1)?'images/01-480.jpg':'images/01-240.jpg');
var e=document.querySelector('.un7');e.setAttribute('src',(dpi>1)?'images/13-480.jpg':'images/13-240.jpg');
var e=document.querySelector('.un8');e.setAttribute('src',(dpi>1)?'images/09-240.jpg':'images/09-120.jpg');
var e=document.querySelector('.un9');e.setAttribute('src',(dpi>1)?'images/05-238.jpg':'images/05-119.jpg');
var e=document.querySelector('.un10');e.setAttribute('src',(dpi>1)?'images/02-480.jpg':'images/02-240.jpg');
var a='data-src';var e=document.querySelector('.un11');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/phone-480.jpg':'images/phone-240.jpg');
var a='data-src';var e=document.querySelector('.un12');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/mail-136.jpg':'images/mail-68.jpg');}else{var e=document.querySelector('.un1');e.setAttribute('src',(dpi>1)?'images/pen2-294.png':'images/pen2-147.png');
var e=document.querySelector('.un3');e.setAttribute('src',(dpi>1)?'images/4-320.jpg':'images/4-160.jpg');
var e=document.querySelector('.un4');e.setAttribute('src',(dpi>1)?'images/03-160.jpg':'images/03-80.jpg');
var e=document.querySelector('.un5');e.setAttribute('src',(dpi>1)?'images/10-160.jpg':'images/10-80.jpg');
var e=document.querySelector('.un6');e.setAttribute('src',(dpi>1)?'images/01-320.jpg':'images/01-160.jpg');
var e=document.querySelector('.un7');e.setAttribute('src',(dpi>1)?'images/13-320.jpg':'images/13-160.jpg');
var e=document.querySelector('.un8');e.setAttribute('src',(dpi>1)?'images/09-160.jpg':'images/09-80.jpg');
var e=document.querySelector('.un9');e.setAttribute('src',(dpi>1)?'images/05-158.jpg':'images/05-79.jpg');
var e=document.querySelector('.un10');e.setAttribute('src',(dpi>1)?'images/02-320.jpg':'images/02-160.jpg');
var a='data-src';var e=document.querySelector('.un11');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/phone-320.jpg':'images/phone-160.jpg');
var a='data-src';var e=document.querySelector('.un12');if(e.hasAttribute('src')){a='src';}e.setAttribute(a,(dpi>1)?'images/mail-90.jpg':'images/mail-45.jpg');}}};
if(!window.HTMLPictureElement){$(window).resize(r);r();}
!function(){var e=document.querySelectorAll('a[href^="#"]:not(.allowConsent,.noConsent,.denyConsent,.removeConsent)');[].forEach.call(e,function(e){e.addEventListener("click",function(o){var t=0;if(e.hash.length>1){var n=parseFloat(getComputedStyle(document.body).getPropertyValue("zoom"));n||(n=1);var l=document.querySelectorAll('[name="'+e.hash.slice(1)+'"]')[0];t=(l.getBoundingClientRect().top+pageYOffset)*n}if("scrollBehavior"in document.documentElement.style)scroll({top:t,left:0,behavior:"smooth"});else if("requestAnimationFrame"in window){var r=pageYOffset,a=null;requestAnimationFrame(function e(o){a||(a=o);var n=o-a;scrollTo(0,r<t?(t-r)*n/400+r:r-(r-t)*n/400),n<400?requestAnimationFrame(e):scrollTo(0,t)})}else scrollTo(0,t);o.preventDefault()},!1)})}();
var s=new Shapes();window.onresize=function(){s.update();};s.update();wl=new woolite();
wl.init();
wl.addAnimation($('.un2'), "2.00s", "0.00s", 1, 100);
wl.addAnimation($('.un13'), "1.50s", "0.00s", 1, 100);
wl.start();
if(location.hash){var e=location.hash.replace("#",""),o=function(){var t=document.querySelectorAll('[name="'+e+'"]')[0];t&&t.scrollIntoView(),"complete"!=document.readyState&&setTimeout(o,100)};o()}

});lfn=function(){ldsrcset('.un66 source');ldsrcset('.un67 source');};if(document.readyState=="complete"){lfn();}else{$(window).on("load",lfn);}