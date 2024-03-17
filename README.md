
1- From "Profile Setting" page -> click on "Block"  
2- Show Alert Dialog that have to button (picture 2) 
3- CLick on "Block" Button -> Dismiss the dialog and update Block status from step 1 to "Unblock"
4- Click "Unblock" from #1 -> Show Alert dialog again, this time button will shown as "Unblolck"
5- Click "Unblock" -> Dismiss the dialog and update Block status

activity_main.xml
-> fragment: nav_hosst_fragment
homefrag-> friends
new->new friend
updte-> update 
<img width="960" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/09ad92ed-ec02-44a8-8ebb-caab0ffd6125">

in homefrag:
<img width="646" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/e43952db-0cba-4bb8-ac0b-0fb2e077cd09">

<img width="588" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/4a1ef4d3-1a91-47d8-bd75-2a947f952b17">
<img width="960" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/2532823c-0c24-4622-9996-b128751b1db2">


<img width="960" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/a31a3498-9126-440b-9457-e7efb1260234">
<img width="406" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/c6c8affa-a8b7-4a49-8bc0-97369302c77b">

homefrag
binding.listItem(linear layout).setOnClickListener(){
val bundle = Bundle()
<img width="498" alt="image" src="https://github.com/Raisin27/FacebookLayout/assets/104148147/ccbd6b04-09f8-418c-9198-fa1577d6fe00">

Update: 
late init var title
late init var img
=>onCreatedView: 
title = requirergument().getString("notetitle").toString()
binding.titleEt.setText(title)
binding.updateBtn.setOnClickListener{

}




##ViewModel
fun insert(friend: Friend) = viewModelScope.lanch{
Dispatchers.IO
repo.insert(friend)
}
...
fun editFriend(){
update(friend)}
fun update()=viewModelScope{}



