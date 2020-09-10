window.addEventListener('DOMContentLoaded', event => {

    //Sidebar Toggler
    const sidebarToggler = document.getElementById('sidebar-toggler')
    //Get A Reference To The Sidebar
    const sidebar = document.getElementById('sidebar')

    //Toggle the sidebar
    if (sidebarToggler) {
        sidebarToggler.addEventListener('click', sidebarTogglerEvent => {

            if (sidebar) {
                if (sidebar.classList.contains('hidden')) sidebar.classList.remove('hidden')
                else sidebar.classList.add('hidden')
            }

        })
    }

})