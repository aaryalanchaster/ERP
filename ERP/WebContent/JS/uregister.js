function date() {
  $("#datepicker").datepicker({
    changeMonth: true,
    changeYear: true,
    yearRange: '-100:+0',
 //   var currentDate = $( ".selector" ).datepicker( "getDate" );
    // onSelect: {
    //   var $this = $(this);
    //   label = $this.prev('label');
    //   console.log(label);
    //   label.addClass('active highlight');
    // }
  });
}


  function change() {
    $('.form').find('input, textarea').on('keyup blur focus click', function (e) {

      var $this = $(this),
        label = $this.prev('label');

      
      if (e.type === 'keyup') {
        if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
      } else if (e.type === 'blur') {
        if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.removeClass('highlight');
        }
      } else if (e.type === 'focus') {

        if ($this.val() === '') {
          label.removeClass('highlight');
        }
        else if ($this.val() !== '') {
          label.addClass('highlight');
        }
      }
      else if(e.type === 'click'){
        if($this.val() !== ''){
          label.addClass('active highlight');
        }
        else{
          label.addClass('active highlight');
        }
      }


    });
  }


$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});