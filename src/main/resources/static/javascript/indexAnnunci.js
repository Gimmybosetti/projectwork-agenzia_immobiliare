const nav = document.querySelector('nav');
window.addEventListener('scroll', function() {
    const offset = window.pageYOffset;
    
    if(offset > 75 ) {
        nav.classList.add('navbar-scrolled')
    }else {
        nav.classList.remove('navbar-scrolled')
    }
});

/********************************************************* */

const iconeDrop = document.querySelectorAll('.il-drop');
console.log(`Ci sono ${iconeDrop.length} icone drop`);

for(let i = 0; i < iconeDrop.length; i++){
    iconeDrop[i].addEventListener('click', cliccato);
    iconeDrop[i].setAttribute('numero-index', i);
}

function cliccato(evento) {
    let iconaDropDown = evento.currentTarget;
    console.log(iconaDropDown.getAttribute('numero-index'));
    let indice = iconaDropDown.getAttribute('numero-index');
    return indice;
}

for(let i = 0; i < iconeDrop.length; i++){
    iconeDrop[i].addEventListener('click', ruotaSuGiu);
}

function ruotaSuGiu(evento2) {
    let ruotaDrop = evento2.currentTarget;
    let indice = ruotaDrop.getAttribute('numero-index');
    if(indice == 0){
        console.log('ruoto il primo')
        const ic = iconeDrop[0].querySelector('.mi-serve');
        console.log(ic.classList);
        console.log(ic.classList.contains('fa-angle-double-up'));
        if(ic.classList.contains('fa-angle-double-up')) {
            ruotaGiu(ic);
            console.log(ic.classList);
        } else {
            ruotaSu(ic);
            console.log(ic.classList);
        }
       
    }
    if(indice == 1){
         console.log('ruoto il secondo');
         const ic = iconeDrop[1].querySelector('.mi-serve');
         console.log(ic.classList);
         console.log(ic.classList.contains('fa-angle-double-up'));
         if(ic.classList.contains('fa-angle-double-up')) {
             ruotaGiu(ic);
         } else {
             ruotaSu(ic);
         }
        
    }
    if(indice == 2){
         console.log('ruoto il terzo');
         const ic = iconeDrop[2].querySelector('.mi-serve');
         console.log(ic.classList);
         console.log(ic.classList.contains('fa-angle-double-up'));
         if(ic.classList.contains('fa-angle-double-up')) {
             ruotaGiu(ic);
         } else {
             ruotaSu(ic);
         }
         
    }
    };
    
    function ruotaSu(icona){
        icona.classList.replace('fa-angle-double-down','fa-angle-double-up')
        // icona.classList.remove('fa-angle-double-down');
        // icona.classList.add('fa-angle-double-up');
    }
    
    function ruotaGiu(icona){
        icona.classList.replace('fa-angle-double-up','fa-angle-double-down')
        // icona.classList.remove('fa-angle-double-up');
        // icona.classList.add('fa-angle-double-down');    
        
    }
    